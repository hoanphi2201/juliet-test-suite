/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__long_console_readLine_preinc_81_goodG2B.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: increment
 *    GoodSink: Ensure there will not be an overflow before incrementing data
 *    BadSink : Increment data, which can cause an overflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE190_Integer_Overflow.s07;
import testcasesupport.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__long_console_readLine_preinc_81_goodG2B extends CWE190_Integer_Overflow__long_console_readLine_preinc_81_base
{
    public void action(long data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Long.MAX_VALUE, this will overflow */
        long result = (long)(++data);

        IO.writeLine("result: " + result);

    }
}
