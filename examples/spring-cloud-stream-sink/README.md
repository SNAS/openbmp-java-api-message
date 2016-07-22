# OpenBMP Message API Example Using Spring Cloud-Stream Sink

You can use [Spring Cloud-Stream](https://cloud.spring.io/spring-cloud-stream/) to create an OpenBMP consuming application. 
Spring Cloud-Stream manages Kafka bindings to topics using a simple configuration file ```application.yml```.   

## Application

A simple application that uses spring cloud-stream sink to connect to OpenBMP Kafka topics as defined 
at [MESSAGE_BUS_API.md](http://openbmp.org/#!docs/MESSAGE_BUS_API.md).  This application will parse 
the OpenBMP messages and log them in **JSON** format.   

| Class            | Description                                            |
| ---------------- | ------------------------------------------------------ |
  SinkApplication  | Spring boot appliation                                 
  SinkInput        | Sink input interface class to define the channels/topics
  LogSink          | Main class where the work is being done.   

## Running
You can run the application in two ways:

    cd examples/spring-cloud-stream-sink

    mvn spring-boot:run
    
**--OR--**

    cd examples/spring-cloud-stream-sink

    mvn clean package
    java -jar target/spring-cloud-stream-sink-example-0.1.0.SNAPSHOT.jar

### Configuration
Configuration is located in ***src/main/resources/application.yml***.  You **MUST** configure this file for your Kafka/Zookeeper configuration.

## Example

```json
2016-07-22 14:20:43.313  INFO 33699 --- [ kafka-binder-4] o.o.api.example.spring.sink.LogSink      : UNICAST_PREFIX: [ {
  "med" : 0,
  "originator_id" : "",
  "aggregator" : "",
  "ext_community_list" : "",
  "origin_as" : 65007,
  "path_id" : 0,
  "router_ip" : "10.200.96.52",
  "isNexthopIPv4" : 0,
  "isAtomicAgg" : 0,
  "prefix_len" : 120,
  "timestamp" : 1469247640498,
  "isIPv4" : 0,
  "base_attr_hash" : "5f97a3ce81e8a83679f6d8ea4ee1c429",
  "action" : "add",
  "community_list" : "",
  "router_hash" : "98d1572b19ae604bac4f58d40a4b4850",
  "cluster_list" : "",
  "hash" : "4fb2a279834ab6017bd64efff8fa9247",
  "as_path_count" : 4,
  "labels" : "",
  "origin" : "igp",
  "as_path" : " 65001 65000 65003 65007",
  "nexthop" : "192:168:1::2",
  "peer_hash" : "0bf4d45a30eb5afbfdfa75970b0d37f7",
  "local_pref" : 0,
  "peer_asn" : 65001,
  "prefix" : "10:0:25::",
  "seq" : 717,
  "peer_ip" : "192.168.1.2"
} ]

2016-07-22 14:20:44.844  INFO 33699 --- [ kafka-binder-7] o.o.api.example.spring.sink.LogSink      : LS LINK: [ {
  "med" : 0,
  "ospf_area_id" : "",
  "router_id" : "10.1.1.5",
  "ls_id" : 0,
  "srlg" : "",
  "router_ip" : "10.200.96.52",
  "remote_igp_router_id" : "",
  "local_node_asn" : 65003,
  "unresv_bw" : "",
  "timestamp" : 1469247640385,
  "local_link_id" : 0,
  "link_protection" : "",
  "peer_node_sid" : "L 0 24008",
  "remote_link_id" : 0,
  "base_attr_hash" : "95339c9e24650da2e6b7117ca8622e73",
  "max_link_bw" : "0",
  "admin_group" : 0,
  "action" : "add",
  "nei_ip" : "192.168.1.4",
  "local_node_hash" : "032d935a23b775786fb47fa67ee2f527",
  "remote_node_asn" : 65005,
  "router_hash" : "98d1572b19ae604bac4f58d40a4b4850",
  "protocol" : "EPE",
  "isis_area_id" : "",
  "remote_node_hash" : "b9d7fb4a63806199dfce4a1cc0b93d43",
  "link_name" : "",
  "hash" : "60d05ee5fc03f7b6509e77cd236b81c8",
  "as_path" : " 65003",
  "mpls_proto_mask" : "",
  "te_default_metric" : 0,
  "nexthop" : "192.168.1.10",
  "remote_router_id" : "10.1.1.4",
  "peer_hash" : "a4d994eafd6387a2f57075de5da7c836",
  "intf_ip" : "192.168.1.5",
  "local_pref" : 0,
  "routing_id" : "0",
  "mt_id" : "0",
  "igp_router_id" : "",
  "peer_asn" : 65003,
  "igp_metric" : 0,
  "max_resv_bw" : "0",
  "seq" : 52,
  "peer_ip" : "192.168.1.10"
} ]

```