# OpenBMP API Message Java Library

This library implements the OpenBMP message bus specification as defined at [MESSAGE_BUS_API.md](http://openbmp.org/#!docs/MESSAGE_BUS_API.md).
 
Messages from kafka (headers and content) are parsed and made available in ```Map``` and String/JSON.    ```ObjectMapper``` can be used to convert to POJO.

> ### Current Schema supported is 1.2

## Install
Currently this is not in maven central, but will be soon.  For now, you should do a ```maven install``` into your local repository.  

    git clone 
    cd openbmp-api-message
    mvn clean install
    
   
 You can also do a ```maven clean package``` to create the **jar** file.
 
## Usage
 
Use this library in any existing java project.
 
### Maven

```xml
    <dependency>
        <groupId>org.openbmp.api</groupId>
        <artifactId>openbmp-api-message</artifactId>
        <version>0.1.0-SNAPSHOT</version>
    </dependency>
```
 
    
### Code

```java
import org.openbmp.api.parsed.message.*;

String raw_kafka_message_data;

Message msg = new Message(raw_kafka_message_data);

// Parse the content data by its type
Peer peer = new Peer(msg.getContent());

// Do something with peer.getRowMap() or peer.toJson()

```

#### Message
Normally the first thing to do is parse the raw Kafka received message by using the ```Message``` class.  This class
will parse the headers and content data. 


#### Message Specific Classes
Each message type, such as ***Router***, ***Peer***, ... are parsed based on  [MESSAGE_BUS_API.md](http://openbmp.org/#!docs/MESSAGE_BUS_API.md).  This is why
there is a separate class for each type.  All classes return the same data for use by your application.  

```java
    /**
     * Get the rowMap
     *
     * @return parsed rowMap is returned
     */
    public List<Map<String, Object>> getRowMap();
    
   /**
     * Get rowMap as Json
     *
     * @return JSON String representing the parsed rowMap
     */
    public String toJson();
    
    /**
     * Get rowMap as Pretty Json
     *
     * @return Pretty formatted JSON String representing the parsed rowMap
     */
    public String toJsonPretty();
}

```


### Spring Cloud-Stream

[Spring Cloud-Stream](https://cloud.spring.io/spring-cloud-stream/) is very easy to use with Kafka and OpenBMP.  
See example [spring-cloud-stream-sink](examples/spring-cloud-stream-sink/README.md) for a working example.  



