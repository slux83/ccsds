/*
 *   Copyright (c) 2019 Dario Lucia (https://www.dariolucia.eu)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package eu.dariolucia.ccsds.tmtc.util;

import static org.junit.jupiter.api.Assertions.fail;

public final class TestUtil {

    public static <T extends Throwable> void assertException(Class<T> c, Runnable r) {
        try {
            r.run();
            fail("Expected exception " + c.getSimpleName() + ", got none");
        } catch(Throwable t) {
            if(c.isAssignableFrom(t.getClass())) {
                // Good
            } else {
                throw new AssertionError("Expected exception " + c.getSimpleName() + ", got " + t.getClass().getSimpleName());
            }
        }
    }
}
