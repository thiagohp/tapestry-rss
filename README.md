tapestry-rss
============

Package that implements an RSS 2.0 feed for Apache Tapestry 5.2 and later versions.

To use it, besides adding it to your classpath, you need to follow this steps:

* Implement a ChannelProvider and contribute it to the ChannelProvider Tapestry-IoC service.
This is how you'll provide the RSS channels and items for tapestry-rss.
* Apply the rss/AddRssLink mixin to some component in your application. It will add the <link>
tag to the page's <header> with all the needed attributes. This mixins' "context" parameter value
will be passed to the contributed ChannelProvider instances.