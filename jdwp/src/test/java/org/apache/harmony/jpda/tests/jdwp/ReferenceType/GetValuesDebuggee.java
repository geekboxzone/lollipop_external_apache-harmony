/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
 * @author Anatoly F. Bondarenko
 */

/**
 * Created on 10.03.2005
 */
package org.apache.harmony.jpda.tests.jdwp.ReferenceType;

import org.apache.harmony.jpda.tests.share.JPDADebuggeeSynchronizer;
import org.apache.harmony.jpda.tests.share.SyncDebuggee;

public class GetValuesDebuggee extends SyncDebuggee {
    
    static int staticIntField;
    static long staticLongField;
    static String staticStringField;
    static GetValuesDebuggee getValuesDebuggeeField;
    static int[] staticArrayField;

    public void run() {
        logWriter.println("--> Debuggee: GetValuesDebuggee: START");

        staticIntField = 99;
        staticLongField = 2147483647;
        staticStringField = "staticStringField";
        getValuesDebuggeeField = new GetValuesDebuggee();
        staticArrayField = new int[10];

        synchronizer.sendMessage(JPDADebuggeeSynchronizer.SGNL_READY);
        synchronizer.receiveMessage(JPDADebuggeeSynchronizer.SGNL_CONTINUE);
        logWriter.println("--> Debuggee: GetValuesDebuggee: FINISH");
    }

    public static void main(String [] args) {
        runDebuggee(GetValuesDebuggee.class);
    }

}