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

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents an RSS 2.0 channel (feed). Each item is structured as an {@link Item} instance.
 * 
 * @author Thiago H. de Paula Figueiredo (http://machina.com.br/thiago)
 * @see Item
 * @see http://cyber.law.harvard.edu/rss/rss.html
 */
public class Channel {

	private String title;

	private String link;

	private String description;

	private List<Item> items = new ArrayList<Item>();

	/**
	 * Constructor which takes the required fields.
	 * 
	 * @param title
	 *            a {@link String} containing the title of the channel.
	 * @param link
	 *            a {@link String} containing the link (URL) of the channel.
	 * @param description
	 *            a {@link String} containing a textual description of the
	 *            channel.
	 */
	public Channel(String title, String link, String description) {

		check(title);
		check(link);
		check(description);

		this.title = title;
		this.link = link;
		this.description = description;

	}

	/**
	 * Returns the value of the title field.
	 * 
	 * @return a {@link String}.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the value of the title field.
	 * 
	 * @param title
	 *            a {@link String}.
	 */
	public void setTitle(String title) {
		check(title);
		this.title = title;
	}

	/**
	 * Returns the value of the link field.
	 * 
	 * @return a {@link String}.
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Sets the value of the link field.
	 * 
	 * @param link
	 *            a {@link String}.
	 */
	public void setLink(String link) {
		check(link);
		this.link = link;
	}

	/**
	 * Returns the value of the description field.
	 * 
	 * @return a {@link String}.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description field.
	 * 
	 * @param description
	 *            a {@link String}.
	 */
	public void setDescription(String description) {
		check(description);
		this.description = description;
	}

	/**
	 * Returns the value of the items field.
	 * 
	 * @return a {@link List<Item>}.
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * Sets the value of the items field.
	 * 
	 * @param items a {@link List<Item>}.
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	private void check(String string) {
		assert string != null && string.length() > 0;
	}

}
