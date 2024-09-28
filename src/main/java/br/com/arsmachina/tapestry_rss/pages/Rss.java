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
package br.com.arsmachina.tapestry_rss.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.ContentType;
import org.apache.tapestry5.commons.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.HttpError;

import br.com.arsmachina.tapestry_rss.Channel;
import br.com.arsmachina.tapestry_rss.Item;
import br.com.arsmachina.tapestry_rss.RssConstants;
import br.com.arsmachina.tapestry_rss.services.ChannelProvider;

/**
 * Page that generates an RSS 2.0 document by passing the activation context to the
 * {@link ChannelProvider} service, getting a {@link Channel} instance from it and then generating
 * the XML content. If {@link ChannelProvider#getChannel(EventContext)} returns null,
 * an HTTP error 404 is raised with a message coming from the {@link RssConstants#HTTP_ERROR_404_MESSAGE_KEY}
 * key.
 * 
 * @author Thiago H. de Paula Figueiredo (http://machina.com.br/thiago)
 * @see ChannelProvider
 * @see Channel
 * @tapestrydoc
 */
@ContentType("application/rss+xml")
public class Rss {
	
	@Inject
	private ChannelProvider channelProvider;
	
	@Inject
	private Messages messages;
	
	private Channel channel;
	
	Object onActivate(EventContext context) {
		channel = channelProvider.getChannel(context);
		return channel != null ? null : new HttpError(404, messages.get(RssConstants.HTTP_ERROR_404_MESSAGE_KEY));
	}

	/**
	 * Writes the RSS document
	 * @param writer a {@link MarkupWriter}.
	 */
	boolean beginRender(MarkupWriter writer) {
		
		writer.element("rss", "version", "2.0", "xmlns:atom", "http://www.w3.org/2005/Atom");
		writer.element("channel");
		write(writer, "title", channel.getTitle());
		write(writer, "link", channel.getLink());
		write(writer, "description", channel.getDescription());
		writer.element("atom:link", "href", channel.getLink(), "rel", "self", "type", "application/rss+xml");
		writer.end(); // atom:link
		
		for (Item item : channel.getItems()) {
			writer.element("item");
			write(writer, "title", item.getTitle());
			write(writer, "description", item.getDescription());
			write(writer, "author", item.getAuthor());
			write(writer, "pubDate", item.getPublicationDate());
			write(writer, "link", item.getLink());
			write(writer, "guid", item.getGuid());
			writer.end(); // item
		}
		
		writer.end(); // channel
		writer.end(); // rss
		
		return false;
		
	}
	
	private void write(MarkupWriter writer, String elementName, String content) {
		if (content != null) {
			writer.element(elementName).text(content);
			writer.end();
		}
	}
	
	private void write(MarkupWriter writer, String elementName, Date date) {
		if (date != null) {
			write(writer, elementName, new SimpleDateFormat(RssConstants.RSS_DATE_FORMAT).format(date));
		}
	}
	
}
