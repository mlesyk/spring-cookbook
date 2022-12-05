package org.mlesyk.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TestBean2 {
    @NotNull
    @Size(min=3)
    private String field1;

    @NotNull
    @Size(min=3)
    private String field2;

    public TestBean2(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public TestBean2() {
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "TestBean2{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }
}
