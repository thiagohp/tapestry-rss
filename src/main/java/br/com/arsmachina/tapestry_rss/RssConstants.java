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
package br.com.arsmachina.tapestry_rss;

import java.text.SimpleDateFormat;

import br.com.arsmachina.tapestry_rss.pages.Rss;

/**
 * Class that contains some constants related to tapestry-rss. 
 * 
 * @author Thiago H. de Paula Figueiredo (http://machina.com.br/thiago)
 */
public class RssConstants {
	
	/**
	 * {@link SimpleDateFormat} pattern following the RFC 822.
	 * @see http://asg.web.cmu.edu/rfc/rfc822.html
	 */
	final public static String RSS_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss Z";
	
	/**
	 * Key of the message used when {@link Rss} receives an invalid page activation context.
	 */
	final public static String HTTP_ERROR_404_MESSAGE_KEY = "tapestry-rss.error-404";
	
	/**
	 * Defines the extension of the URL of the RSS feed.
	 */
	final public static String URL_EXTENSION = "rss";

	/**
	 * Prefix used by this library mapping
	 */
	public static final String LIBRARY_MAPPING_PREFIX = "rss";
	
	private RssConstants() {
	}

}
