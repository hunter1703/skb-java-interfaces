/* Copyright 2016 Sven van der Meer <vdmeer.sven@mykolab.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.vandermeer.skb.interfaces.transformers;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

/**
 * Transforms the input provided by an `array` into text using String Templates.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 170331 (31-Mar-17) for Java 1.8
 * @since      v0.0.1
 */
public interface Array_To_Text<T> extends IsTransformer<T[], String> {

	@Override
	default String transform(T[] ar){
		IsTransformer.super.transform(ar);

		STGroup stg = new STGroupString(Iterable_To_Text.TO_STRING_ST);
		ST ret = stg.getInstanceOf("toText");

		for(Object obj : ar){
			ret.add("entries", obj);
		}
		return ret.render();
	}

	/**
	 * Creates a new transformer.
	 * @param <T> type of the array
	 * @return new transformer
	 */
	static <T> Array_To_Text<T> create(){
		return new Array_To_Text<T>() {};
	}
}
