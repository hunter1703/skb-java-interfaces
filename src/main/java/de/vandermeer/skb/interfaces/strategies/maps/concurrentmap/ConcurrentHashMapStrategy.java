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

package de.vandermeer.skb.interfaces.strategies.maps.concurrentmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.vandermeer.skb.interfaces.strategies.maps.IsConcurrentMapStrategy;

/**
 * Strategy for a concurrent hash map.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.0.1
 */
public interface ConcurrentHashMapStrategy<K, V> extends IsConcurrentMapStrategy<K, V> {

	@Override
	default ConcurrentHashMap<K, V> get() {
		return new ConcurrentHashMap<>();
	}

	@Override
	default ConcurrentHashMap<K, V> get(Map<K, V> map){
		return new ConcurrentHashMap<>(map);
	}

	/**
	 * Creates a new concurrent hash map strategy.
	 * @param <K> type of the keys in the map
	 * @param <V> type of the values in the map
	 * @return concurrent hash map strategy
	 */
	static <K, V> ConcurrentHashMapStrategy<K, V> create(){
		return new ConcurrentHashMapStrategy<K, V>() {};
	}
}
