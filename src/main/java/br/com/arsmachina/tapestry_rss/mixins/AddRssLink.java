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
package br.com.arsmachina.tapestry_rss.mixins;

import java.util.List;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;

import br.com.arsmachina.tapestry_rss.Channel;
import br.com.arsmachina.tapestry_rss.pages.Rss;
import br.com.arsmachina.tapestry_rss.services.ChannelProvider;

/**
 * Mixin that that adds a <code>&lt;link href="xxx" rel="alternate" type="application/rss+xml" title="yyy"/&gt;</code>
 * element to the <code>&lt;head&gt;</code> of a page. The value passed to the <code>context</code>
 * parameter should be handled by a {@link ChannelProvider} in order for the link to work. 
 * 
 * @author Thiago H. de Paula Figueiredo (http://machina.com.br/thiago)
 * @see ChannelProvider
 * @see Channel
 * @tapestrydoc
 */
public class AddRssLink {
	
	/**
	 * Page activation context that will be passed to the {@link Rss} page.
	 */
	@Parameter(required = true, allowNull = false)
	private List<?> context;
	
	/**
	 * <code>title</code> attribute to be used in the generated link.
	 */
	@Parameter
	private String title;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	/**
	 * Creates the RSS file URL and  
	 * @param writer
	 */
	void afterRender(MarkupWriter writer) {
		final Element head = writer.getDocument().getRootElement().find("head");
		head.element("link", "rel", "alternate", "type", "application/rss+xml", "title", title,
				"href", pageRenderLinkSource.createPageRenderLinkWithContext(Rss.class, context.toArray()).toAbsoluteURI());
	}
	
}
