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

import java.util.Date;

/**
 * Class that represents an RSS 2.0 item of a channel (feed).
 * 
 * @author Thiago H. de Paula Figueiredo (http://machina.com.br/thiago)
 * @see http://cyber.law.harvard.edu/rss/rss.html
 * @see Channel
 */
public class Item {
	
	private String title;
	
	private String description;
	
	private String author;
	
	private Date publicationDate;
	
	private String link;
	
	private String guid;

	/**
	 * Returns the value of the title field.
	 * @return a {@link String}.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the value of the title field.
	 * @param title a {@link String}.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the value of the description field.
	 * @return a {@link String}.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description field.
	 * @param description a {@link String}.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the value of the author field.
	 * @return a {@link String}.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the value of the author field.
	 * @param author a {@link String}.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Returns the value of the publicationDate field.
	 * @return a {@link Date}.
	 */
	public Date getPublicationDate() {
		return publicationDate;
	}

	/**
	 * Sets the value of the publicationDate field.
	 * @param publicationDate a {@link Date}.
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * Returns the value of the link field.
	 * @return a {@link String}.
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Sets the value of the link field.
	 * @param link a {@link String}.
	 */
	public void setLink(String link) {
		this.link = link;
		if (getGuid() == null) {
			setGuid(link);
		}
	}

	/**
	 * Returns the value of the guid field.
	 * @return a {@link String}.
	 */
	public String getGuid() {
		if (guid == null) {
			setGuid(getLink());
		}
		return guid;
	}

	/**
	 * Sets the value of the guid field.
	 * @param guid a {@link String}.
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}

}
