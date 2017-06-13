package org.openbmp.api.parsed.message;

/**
 * Enum to define all the headers and their default values.
 *
 * @author mmaredia
 */
public enum MsgBusFields {


    ACTION("action", ""),
    SEQUENCE("seq", 0),
    HASH("hash", ""),
    BASE_ATTR_HASH("base_attr_hash", ""),
    ROUTER_HASH("router_hash", ""),
    ROUTER_IP("router_ip", ""),
    PEER_HASH("peer_hash", ""),
    PEER_IP("peer_ip", ""),
    PEER_ASN("peer_asn", 0),
    TIMESTAMP("timestamp", ""),
    IGP_ROUTER_ID("igp_router_id", ""),
    ROUTER_ID("router_id", ""),
    ROUTING_ID("routing_id", 0),
    LS_ID("ls_id", 0),
    MT_ID("mt_id", ""),
    OSPF_AREA_ID("ospf_area_id", ""),
    ISIS_AREA_ID("isis_area_id", ""),
    PROTOCOL("protocol", ""),
    FLAGS("flags", ""),
    AS_PATH("as_path", ""),
    LOCAL_PREF("local_pref", 0),
    MED("med", 0),
    NEXTHOP("nexthop", ""),
    NAME("name", ""),
    ISPREPOLICY("isPrePolicy", 1),
    IS_ADJ_RIB_IN("isAdjRibIn", 1),
    ORIGIN("origin", ""),
    AS_PATH_COUNT("as_path_count", 0),
    ORIGIN_AS("origin_as", 0),
    AGGREGATOR("aggregator", ""),
    COMMUNITY_LIST("community_list", ""),
    EXT_COMMUNITY_LIST("ext_community_list", ""),
    CLUSTER_LIST("cluster_list", ""),
    ISATOMICAGG("isAtomicAgg", 1),
    IS_NEXTHOP_IPV4("isNexthopIPv4", 1),
    ORIGINATOR_ID("originator_id", ""),
    LOCAL_LINK_ID("local_link_id", 0),
    REMOTE_LINK_ID("remote_link_id", 0),
    INTF_IP("intf_ip", ""),
    NEI_IP("nei_ip", ""),
    IGP_METRIC("igp_metric", 0),
    ADMIN_GROUP("admin_group", 0),
    MAX_LINK_BW("max_link_bw", 0),
    MAX_RESV_BW("max_resv_bw", 0),
    UNRESV_BW("unresv_bw", ""),
    TE_DEFAULT_METRIC("te_default_metric", 0),
    LINK_PROTECTION("link_protection", ""),
    MPLS_PROTO_MASK("mpls_proto_mask", ""),
    SRLG("srlg", ""),
    LINK_NAME("link_name", ""),
    REMOTE_NODE_HASH("remote_node_hash", ""),
    LOCAL_NODE_HASH("local_node_hash", ""),
    REMOTE_IGP_ROUTER_ID("remote_igp_router_id", ""),
    REMOTE_ROUTER_ID("remote_router_id", ""),
    LOCAL_NODE_ASN("local_node_asn", 0),
    REMOTE_NODE_ASN("remote_node_asn", 0),
    PEER_NODE_SID("peer_node_sid", ""),
    REJECTED("rejected", 0),
    KNOWN_DUP_UPDATES("known_dup_updates", 0),
    KNOWN_DUP_WITHDRAWS("known_dup_withdraws", 0),
    INVALID_CLUSTER_LIST("invalid_cluster_list", 0),
    INVALID_AS_PATH("invalid_as_path", 0),
    INVALID_ORIGINATOR("invalid_originator", 0),
    INVALID_AS_CONFED("invalid_as_confed", 0),
    PRE_POLICY("pre_policy", 0),
    POST_POLICY("post_policy", 0),
    ADMIN_ID("admin_id", ""),
    ROUTERS("routers", ""),
    ROUTER_COUNT("router_count", 0),
    OSPF_ROUTE_TYPE("ospf_route_type", ""),
    IGP_FLAGS("igp_flags", ""),
    ROUTE_TAG("route_tag", 0),
    EXT_ROUTE_TAG("ext_route_tag", 0),
    OSPF_FWD_ADDR("ospf_fwd_addr", ""),
    PREFIX("prefix", ""),
    PREFIX_LEN("prefix_len", 0),
    REMOTE_BGP_ID("remote_bgp_id", ""),
    REMOTE_ASN("remote_asn", 0),
    REMOTE_IP("remote_ip", ""),
    PEER_RD("peer_rd", ""),
    REMOTE_PORT("remote_port", 0),
    LOCAL_ASN("local_asn", 0),
    LOCAL_IP("local_ip", ""),
    LOCAL_PORT("local_port", 0),
    LOCAL_BGP_ID("local_bgp_id", ""),
    INFO_DATA("info_data", ""),
    ADV_CAP("adv_cap", ""),
    RECV_CAP("recv_cap", ""),
    REMOTE_HOLDDOWN("remote_holddown", 0),
    ADV_HOLDDOWN("adv_holddown", 0),
    BMP_REASON("bmp_reason", 0),
    BGP_ERROR_CODE("bgp_error_code", 0),
    BGP_ERROR_SUB_CODE("bgp_error_sub_code", 0),
    ERROR_TEXT("error_text", ""),
    IS_L3VPN("isL3VPN", 1),
    IS_IPV4("isIPv4", 1),
    IP_ADDRESS("ip_address", ""),
    DESCRIPTION("description", ""),
    TERM_CODE("term_code", 0),
    TERM_REASON("term_reason", ""),
    INIT_DATA("init_data", ""),
    TERM_DATA("term_data", ""),
    BGP_ID("bgp_id", ""),
    PATH_ID("path_id", 0),
    LABELS("labels", ""),
    LS_SR_CAPABILITIES("sr_capabilities", ""),
    LS_ADJACENCY_SID("sr_adjacency_sid", ""),
    LS_PREFIX_SID("sr_prefix_sid", ""),
    VPN_RD("rd", ""),
    VPN_RD_TYPE("rd_type", 1);


    private final String name;
    private final Object defaultValue;

    private MsgBusFields(String name, Object value) {
        this.name = name;
        this.defaultValue = value;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public String getName() {
        return name;
    }


}
