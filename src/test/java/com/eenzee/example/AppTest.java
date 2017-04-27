package com.eenzee.example;

import com.eenzee.example.rest.model.ExampleBody;
import com.eenzee.example.rest.model.ReturnBody;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testXMLMarshall() throws Exception{
        ExampleBody exampleBody = new ExampleBody();
        exampleBody.setaInteger(27);
        exampleBody.setaLong(123L);
        exampleBody.setaString("astring");
        ReturnBody returnBody = new ReturnBody("path", exampleBody);
        returnBody.setQueryParam("query");
        JAXBContext jaxbContext = JAXBContext.newInstance(ReturnBody.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal(returnBody,sw);
        System.out.println(sw.toString());
    }
}
