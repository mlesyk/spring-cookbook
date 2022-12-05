package org.mlesyk.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TestBean {

    @NotNull
    @Size(min=3)
    private String field1;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate field2;

    @Min(5)
    @Max(25)
    private int field3;

    @Valid
    private TestBean2 field4;

    public TestBean(String field1, LocalDate field2, int field3, TestBean2 field4) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    public TestBean() {
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public LocalDate getField2() {
        return field2;
    }

    public void setField2(LocalDate field2) {
        this.field2 = field2;
    }

    public int getField3() {
        return field3;
    }

    public void setField3(int field3) {
        this.field3 = field3;
    }

    public TestBean2 getField4() {
        return field4;
    }

    public void setField4(TestBean2 field4) {
        this.field4 = field4;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                ", field3=" + field3 +
                ", field4=" + field4 +
                '}';
    }
}
