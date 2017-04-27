package com.eenzee.example.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * An example body - jaxb annotation is for the return value;
 * for unmarshalling the body from the request, we need to either have public getters and setters with get/set + the name of the field
 * There may also be a way to do this via a constructor so you can make all arguments final.
 */
@XmlRootElement
public class ExampleBody {
    String aString;
    Integer aInteger;
    Long aLong;

    /**
     * No arg constructor for marshalling
     */
    public ExampleBody(){}

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public Integer getaInteger() {
        return aInteger;
    }

    public void setaInteger(Integer aInteger) {
        this.aInteger = aInteger;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExampleBody that = (ExampleBody) o;

        if (aString != null ? !aString.equals(that.aString) : that.aString != null) return false;
        if (aInteger != null ? !aInteger.equals(that.aInteger) : that.aInteger != null) return false;
        return aLong != null ? aLong.equals(that.aLong) : that.aLong == null;
    }

    @Override
    public int hashCode() {
        int result = aString != null ? aString.hashCode() : 0;
        result = 31 * result + (aInteger != null ? aInteger.hashCode() : 0);
        result = 31 * result + (aLong != null ? aLong.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExampleBody{" +
                "aString='" + aString + '\'' +
                ", aInteger=" + aInteger +
                ", aLong=" + aLong +
                '}';
    }
}
