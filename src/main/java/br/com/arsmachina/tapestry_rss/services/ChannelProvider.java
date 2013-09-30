// Copyright 2013 Thiago H. de Paula Figueiredo
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// Copyright 2013 Thiago H. de Paula Figueiredo
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package br.com.arsmachina.tapestry_rss.services;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.ioc.annotations.UsesOrderedConfiguration;

import br.com.arsmachina.tapestry_rss.Channel;
import br.com.arsmachina.tapestry_rss.pages.Rss;

/**
 * Chain-of-responsibility service that should return a {@link Channel} object corresponding
 * to a given page activation context passed to the {@link Rss} page. If a given implementation
 * doesn't handle a given context, it should simply return <code>null</code>. All the contributed 
 * ChannelProvider implementations will be invoked until one of them returns a non-null {@link Channel}. 
 * 
 * @author Thiago H. de Paula Figueiredo (http://machina.com.br/thiago)
 * @see Channel
 * @tapestrydoc
 */
@UsesOrderedConfiguration(ChannelProvider.class)
public interface ChannelProvider {
	
	/**
	 * Provides the {@link Channel} object corresponding to a given {@link EventContext} passed to
	 * the {@link Rss} page.
	 * 
	 * @param context an {@link EventContext}.
	 * @return a {@link Channel} instance of <code>null</code>.
	 */
	Channel getChannel(EventContext context);
	
}
