package org.openbmp.api.parsed.message;

/**
 * Enum to define all the headers and their default values. 
 * @author mmaredia
 *
 */
public enum HeaderDefault {
	
	
	action(""),
	seq(0),
	hash(""),
	base_attr_hash(""),
	router_hash(""),
	router_ip(""),
	peer_hash(""),
	peer_ip(""),
	peer_asn(0),
	timestamp(""),
	igp_router_id(""),
	router_id(""),
	routing_id(0),
	ls_id(0),
	mt_id(""),
	ospf_area_id(""),
	isis_area_id(""),
	protocol(""),
	flags(""),
	as_path(""),
	local_pref(0),
	med(0),
	nexthop(""),
	name(""),
	isPrePolicy(1),
	isAdjRibIn(1),
	origin(""),
	as_path_count(0),
	origin_as(0),
	aggregator(""),
	community_list(""),
	ext_community_list(""),
	cluster_list(""),
	isAtomicAgg(1),
	isNexthopIPv4(1),
	originator_id(""),
	local_link_id(0),
	remote_link_id(0),
	intf_ip(""),
	nei_ip(""),
	igp_metric(0),
	admin_group(0),
	max_link_bw(0),
	max_resv_bw(0),
	unresv_bw(""),
	te_default_metric(0),
	link_protection(""),
	mpls_proto_mask(""),
	srlg(""),
	link_name(""),
	remote_node_hash(""),
	local_node_hash(""),
	remote_igp_router_id(""),
	remote_router_id(""),
	local_node_asn(0),
	remote_node_asn(0),
	peer_node_sid(""),
	rejected(0),
	known_dup_updates(0),
	known_dup_withdraws(0),
	invalid_cluster_list(0),
	invalid_as_path(0),
	invalid_originator(0),
	invalid_as_confed(0),
	pre_policy(0),
	post_policy(0),
	admin_id(""),
	routers(""),
	router_count(0),
	ospf_route_type(""),
	igp_flags(""),
	route_tag(0),
	ext_route_tag(0),
	ospf_fwd_addr(""),
	prefix(""),
	prefix_len(0),
	remote_bgp_id(""),
	remote_asn(0),
	remote_ip(""),
	peer_rd(""),
	remote_port(0),
	local_asn(0),
	local_ip(""),
	local_port(0),
	local_bgp_id(""),
	info_data(""),
	adv_cap(""),
	recv_cap(""),
	remote_holddown(0),
	adv_holddown(0),
	bmp_reason(0),
	bgp_error_code(0),
	bgp_error_sub_code(0),
	error_text(""),
	isL3VPN(1),
	isIPv4(1),
	ip_address(""),
	description(""),
	term_code(0),
	term_reason(""),
	init_data(""),
	term_data(""),
	bgp_id(""),
	path_id(0),
	labels(""),
	router_tag(""),
	ext_router_tag("");
	
	
	
	private Object value;
	
	private HeaderDefault(Object value){
		
		this.value = value;
	}

	public Object getDefaultValue(){
		
		return this.value;
	}
	
	
	

}
