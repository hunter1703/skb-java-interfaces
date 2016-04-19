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

package de.vandermeer.skb.interfaces.strategies.collections.queue;

import java.util.Collection;
import java.util.PriorityQueue;

import de.vandermeer.skb.interfaces.strategies.collections.IsQueueStrategy;

/**
 * Strategy for a priority queue.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 160319 (19-Mar-16) for Java 1.8
 * @since      v0.0.1
 */
public interface PriorityQueueStrategy<T> extends IsQueueStrategy<PriorityQueue<T>, T> {

	@Override
	default PriorityQueue<T> get(Collection<T> collection) {
		PriorityQueue<T> ret = new PriorityQueue<T>();
		if(collection!=null){
			ret.addAll(collection);
		}
		return ret;
	}

	@Override
	default PriorityQueue<T> get() {
		return new PriorityQueue<T>();
	}

	/**
	 * Creates a new priority queue strategy.
	 * @param <T> type for the objects in the queue
	 * @return new priority queue strategy
	 */
	static <T> PriorityQueueStrategy<T> create(){
		return new PriorityQueueStrategy<T>(){};
	}
}
