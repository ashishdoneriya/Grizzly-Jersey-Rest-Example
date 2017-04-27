package com.eenzee.example.rest.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReturnBody {
    private String pathParam;
    private String queryParam = "";
    private ExampleBody exampleBody;

    /**
     * JAXB requires a no arg constructor
     */
    public ReturnBody(){}

    public ReturnBody(String pathParam, ExampleBody exampleBody){
        this.pathParam = pathParam;
        this.exampleBody = exampleBody;
    }

    @XmlElement
    public String getPathParam() {
        return pathParam;
    }

    public void setPathParam(String pathParam) {
        this.pathParam = pathParam;
    }

    @XmlAttribute
    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public ExampleBody getExampleBody() {
        return exampleBody;
    }

    public void setExampleBody(ExampleBody exampleBody) {
       this.exampleBody = exampleBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReturnBody that = (ReturnBody) o;

        if (pathParam != null ? !pathParam.equals(that.pathParam) : that.pathParam != null) return false;
        return queryParam != null ? queryParam.equals(that.queryParam) : that.queryParam == null;
    }

    @Override
    public int hashCode() {
        int result = pathParam != null ? pathParam.hashCode() : 0;
        result = 31 * result + (queryParam != null ? queryParam.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReturnBody{" +
                "pathParam='" + pathParam + '\'' +
                ", queryParam='" + queryParam + '\'' +
                '}';
    }
}
