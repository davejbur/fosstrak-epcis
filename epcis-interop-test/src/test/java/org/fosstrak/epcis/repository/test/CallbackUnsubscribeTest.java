/*
 * Copyright (C) 2007 ETH Zurich
 *
 * This file is part of Fosstrak (www.fosstrak.org).
 *
 * Fosstrak is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1, as published by the Free Software Foundation.
 *
 * Fosstrak is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Fosstrak; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

package org.fosstrak.epcis.repository.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import junit.framework.TestCase;

import org.fosstrak.epcis.queryclient.QueryControlClient;
import org.fosstrak.epcis.soap.NoSuchSubscriptionExceptionResponse;
import org.fosstrak.epcis.utils.QueryCallbackListener;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Test for unsubscribing queries (SE44).
 *
 * @author Marco Steybe
 */
public class CallbackUnsubscribeTest extends TestCase {

    private static final Log LOG = LogFactory.getLog(CallbackUnsubscribeTest.class);
    private static final String PATH = "src/test/resources/queries/webservice/requests/";

    private static QueryControlClient client = new QueryControlClient();

    /**
     * Tests if we receive a notification for a subscribed query, and we receive
     * no further notification after the query is unsubscribed.
     *
     * @throws Exception
     *             Any exception, caught by the JUnit framework.
     */
    public void testSE44() throws Exception {
        final String query = "Test-EPCIS10-SE44-Request-1-Subscribe.xml";

        // subscribe a query
        InputStream fis = new FileInputStream(PATH + query);
        client.subscribe(fis);
        fis.close();

        // start subscription response listener
        QueryCallbackListener listener = QueryCallbackListener.getInstance();
        if (!listener.isRunning()) {
            listener.start();
        }
        System.out.println("waiting ...");
        synchronized (listener) {
            try {
                listener.wait(15000);
            } catch (InterruptedException e) {
                LOG.error("Exception: ",e);
            }
        }
        String resp1 = listener.fetchResponse();
        assertNotNull(resp1);

        // parse response to make sure we got back a result
        Document epcis = parseResponse(resp1);
        Node eventList = epcis.getElementsByTagName("EventList").item(0);
        assertTrue(eventList.hasChildNodes());

        // unsubscribe the query and wait for any response
        client.unsubscribe("QuerySE44");
        System.out.println("waiting ...");
        synchronized (listener) {
            try {
                listener.wait(15000);
            } catch (InterruptedException e) {
                LOG.error("Exception: ",e);
            }
        }
        String resp2 = listener.fetchResponse();
        assertNull("No response expected, but received: " + resp2, resp2);
        listener.stopRunning();
    }

    /**
     * Parses a string into an XML Document.
     *
     * @param resp
     *            The string to be parsed.
     * @return The parsed XML Document.
     * @throws ParserConfigurationException
     *             If the parser could not be configured.
     * @throws SAXException
     *             If a parse error occurred.
     * @throws IOException
     *             If an I/O error occurred.
     */
    private Document parseResponse(final String resp) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource xmlInput = new InputSource(new StringReader(resp));
        return builder.parse(xmlInput);
    }

    /**
     * {@inheritDoc}
     *
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    protected void tearDown() throws Exception {
        try {
            client.unsubscribe("QuerySE44");
        } catch (NoSuchSubscriptionExceptionResponse e) {
        }
    }
}
