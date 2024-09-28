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
package br.com.arsmachina.tapestry_rss.internal;

import org.apache.tapestry5.http.Link;
import org.apache.tapestry5.http.services.Request;
import org.apache.tapestry5.services.PageRenderRequestParameters;
import org.apache.tapestry5.services.linktransform.PageRenderLinkTransformer;

import br.com.arsmachina.tapestry_rss.RssConstants;
import br.com.arsmachina.tapestry_rss.pages.Rss;

/**
 * Rewrites <code>/rss/rss/*</code> links to <code>/rss/*</code>.
 * 
 * @author Thiago H. de Paula Figueiredo (http://machina.com.br/thiago)
 */
public class RssLinkTransformer implements PageRenderLinkTransformer {
	
	final private static String PAGE_NAME = RssConstants.LIBRARY_MAPPING_PREFIX + "/" + Rss.class.getSimpleName();

	public Link transformPageRenderLink(Link defaultLink,
			PageRenderRequestParameters parameters) {
		
		Link link = null;
		final String logicalPageName = parameters.getLogicalPageName();
		if (logicalPageName.equals(PAGE_NAME)) {
			link = defaultLink.copyWithBasePath(defaultLink.getBasePath().replaceFirst(Constants.ORIGINAL, Constants.SHORTENED));
		}
		
		return link;
		
	}

	/**
	 * Does nothing.
	 * @return <code>null</code>.
	 */
	public PageRenderRequestParameters decodePageRenderRequest(Request request) {
		return null;
	}

}
