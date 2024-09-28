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

import java.util.List;

import org.apache.tapestry5.commons.Configuration;
import org.apache.tapestry5.commons.OrderedConfiguration;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Primary;
import org.apache.tapestry5.ioc.services.ChainBuilder;
import org.apache.tapestry5.services.ComponentClassResolver;
import org.apache.tapestry5.services.LibraryMapping;
import org.apache.tapestry5.services.linktransform.PageRenderLinkTransformer;
import org.apache.tapestry5.urlrewriter.URLRewriterRule;

import br.com.arsmachina.tapestry_rss.RssConstants;
import br.com.arsmachina.tapestry_rss.internal.RssLinkTransformer;
import br.com.arsmachina.tapestry_rss.internal.RssURLRewriterRule;

/**
 * Tapestry-IoC class module for tapestry-rss.
 * 
 * @author Thiago H. de Paula Figueiredo (http://machina.com.br/thiago)
 */
public class RssModule {
	
	/**
	 * Contributes this module's to Tapestry as a component library.
	 */
	@Contribute(ComponentClassResolver.class)
	public static void addLibraryMapping(Configuration<LibraryMapping> configuration) {
		configuration.add(new LibraryMapping(RssConstants.LIBRARY_MAPPING_PREFIX, "br.com.arsmachina.tapestry_rss"));
	}
	
	/**
	 * Creates the {@link ChannelProvider} service.
	 */
	public static ChannelProvider buildChannelProvider(List<ChannelProvider> configuration,
			ChainBuilder chainBuilder) {
		return chainBuilder.build(ChannelProvider.class, configuration);
	}
	
	/**
	 * Contributes {@link RssLinkTransformer}.
	 * @param configuration an {@link OrderedConfiguration}.
	 */
	@Primary
	public static void contributePageRenderLinkTransformer(OrderedConfiguration<PageRenderLinkTransformer> configuration) {
		configuration.addInstance("Rss", RssLinkTransformer.class);
	}
	
	/**
	 * Contributes the {@link RssURLRewriterRule}.
	 * @param configuration an {@link OrderedConfiguration}.
	 */
	public static void contributeURLRewriter(OrderedConfiguration<URLRewriterRule> configuration) {
		configuration.addInstance("RSS", RssURLRewriterRule.class, "after:Subdomain");
	}

}
