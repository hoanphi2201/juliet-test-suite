/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_console_readLine_postinc_73b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: increment
 *    GoodSink: Ensure there will not be an overflow before incrementing data
 *    BadSink : Increment data, which can cause an overflow
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s06;
import testcasesupport.*;
import java.util.LinkedList;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_console_readLine_postinc_73b
{
    public void badSink(LinkedList<Byte> dataLinkedList ) throws Throwable
    {
        byte data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: if data == Byte.MAX_VALUE, this will overflow */
        data++;
        byte result = (byte)(data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(LinkedList<Byte> dataLinkedList ) throws Throwable
    {
        byte data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: if data == Byte.MAX_VALUE, this will overflow */
        data++;
        byte result = (byte)(data);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(LinkedList<Byte> dataLinkedList ) throws Throwable
    {
        byte data = dataLinkedList.remove(2);

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Byte.MAX_VALUE)
        {
            data++;
            byte result = (byte)(data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to increment.");
        }

    }
}
