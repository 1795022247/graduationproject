package com.jesper.model;

import java.util.ArrayList;
import java.util.List;

public class RoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRoomNoIsNull() {
            addCriterion("room_no is null");
            return (Criteria) this;
        }

        public Criteria andRoomNoIsNotNull() {
            addCriterion("room_no is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNoEqualTo(String value) {
            addCriterion("room_no =", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoNotEqualTo(String value) {
            addCriterion("room_no <>", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoGreaterThan(String value) {
            addCriterion("room_no >", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoGreaterThanOrEqualTo(String value) {
            addCriterion("room_no >=", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoLessThan(String value) {
            addCriterion("room_no <", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoLessThanOrEqualTo(String value) {
            addCriterion("room_no <=", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoLike(String value) {
            addCriterion("room_no like", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoNotLike(String value) {
            addCriterion("room_no not like", value, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoIn(List<String> values) {
            addCriterion("room_no in", values, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoNotIn(List<String> values) {
            addCriterion("room_no not in", values, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoBetween(String value1, String value2) {
            addCriterion("room_no between", value1, value2, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNoNotBetween(String value1, String value2) {
            addCriterion("room_no not between", value1, value2, "roomNo");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNull() {
            addCriterion("room_type is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNotNull() {
            addCriterion("room_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeEqualTo(String value) {
            addCriterion("room_type =", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotEqualTo(String value) {
            addCriterion("room_type <>", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThan(String value) {
            addCriterion("room_type >", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("room_type >=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThan(String value) {
            addCriterion("room_type <", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThanOrEqualTo(String value) {
            addCriterion("room_type <=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLike(String value) {
            addCriterion("room_type like", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotLike(String value) {
            addCriterion("room_type not like", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIn(List<String> values) {
            addCriterion("room_type in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotIn(List<String> values) {
            addCriterion("room_type not in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeBetween(String value1, String value2) {
            addCriterion("room_type between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotBetween(String value1, String value2) {
            addCriterion("room_type not between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andHotolIdIsNull() {
            addCriterion("hotol_id is null");
            return (Criteria) this;
        }

        public Criteria andHotolIdIsNotNull() {
            addCriterion("hotol_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotolIdEqualTo(Integer value) {
            addCriterion("hotol_id =", value, "hotolId");
            return (Criteria) this;
        }

        public Criteria andHotolIdNotEqualTo(Integer value) {
            addCriterion("hotol_id <>", value, "hotolId");
            return (Criteria) this;
        }

        public Criteria andHotolIdGreaterThan(Integer value) {
            addCriterion("hotol_id >", value, "hotolId");
            return (Criteria) this;
        }

        public Criteria andHotolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotol_id >=", value, "hotolId");
            return (Criteria) this;
        }

        public Criteria andHotolIdLessThan(Integer value) {
            addCriterion("hotol_id <", value, "hotolId");
            return (Criteria) this;
        }

        public Criteria andHotolIdLessThanOrEqualTo(Integer value) {
            addCriterion("hotol_id <=", value, "hotolId");
            return (Criteria) this;
        }

        public Criteria andHotolIdIn(List<Integer> values) {
            addCriterion("hotol_id in", values, "hotolId");
            return (Criteria) this;
        }

        public Criteria andHotolIdNotIn(List<Integer> values) {
            addCriterion("hotol_id not in", values, "hotolId");
            return (Criteria) this;
        }

        public Criteria andHotolIdBetween(Integer value1, Integer value2) {
            addCriterion("hotol_id between", value1, value2, "hotolId");
            return (Criteria) this;
        }

        public Criteria andHotolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hotol_id not between", value1, value2, "hotolId");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(Integer value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(Integer value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(Integer value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(Integer value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(Integer value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<Integer> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<Integer> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(Integer value1, Integer value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(Integer value1, Integer value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andFalg1IsNull() {
            addCriterion("falg1 is null");
            return (Criteria) this;
        }

        public Criteria andFalg1IsNotNull() {
            addCriterion("falg1 is not null");
            return (Criteria) this;
        }

        public Criteria andFalg1EqualTo(String value) {
            addCriterion("falg1 =", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1NotEqualTo(String value) {
            addCriterion("falg1 <>", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1GreaterThan(String value) {
            addCriterion("falg1 >", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1GreaterThanOrEqualTo(String value) {
            addCriterion("falg1 >=", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1LessThan(String value) {
            addCriterion("falg1 <", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1LessThanOrEqualTo(String value) {
            addCriterion("falg1 <=", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1Like(String value) {
            addCriterion("falg1 like", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1NotLike(String value) {
            addCriterion("falg1 not like", value, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1In(List<String> values) {
            addCriterion("falg1 in", values, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1NotIn(List<String> values) {
            addCriterion("falg1 not in", values, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1Between(String value1, String value2) {
            addCriterion("falg1 between", value1, value2, "falg1");
            return (Criteria) this;
        }

        public Criteria andFalg1NotBetween(String value1, String value2) {
            addCriterion("falg1 not between", value1, value2, "falg1");
            return (Criteria) this;
        }

        public Criteria andFlag2IsNull() {
            addCriterion("flag2 is null");
            return (Criteria) this;
        }

        public Criteria andFlag2IsNotNull() {
            addCriterion("flag2 is not null");
            return (Criteria) this;
        }

        public Criteria andFlag2EqualTo(String value) {
            addCriterion("flag2 =", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2NotEqualTo(String value) {
            addCriterion("flag2 <>", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2GreaterThan(String value) {
            addCriterion("flag2 >", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2GreaterThanOrEqualTo(String value) {
            addCriterion("flag2 >=", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2LessThan(String value) {
            addCriterion("flag2 <", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2LessThanOrEqualTo(String value) {
            addCriterion("flag2 <=", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2Like(String value) {
            addCriterion("flag2 like", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2NotLike(String value) {
            addCriterion("flag2 not like", value, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2In(List<String> values) {
            addCriterion("flag2 in", values, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2NotIn(List<String> values) {
            addCriterion("flag2 not in", values, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2Between(String value1, String value2) {
            addCriterion("flag2 between", value1, value2, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag2NotBetween(String value1, String value2) {
            addCriterion("flag2 not between", value1, value2, "flag2");
            return (Criteria) this;
        }

        public Criteria andFlag3IsNull() {
            addCriterion("flag3 is null");
            return (Criteria) this;
        }

        public Criteria andFlag3IsNotNull() {
            addCriterion("flag3 is not null");
            return (Criteria) this;
        }

        public Criteria andFlag3EqualTo(String value) {
            addCriterion("flag3 =", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3NotEqualTo(String value) {
            addCriterion("flag3 <>", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3GreaterThan(String value) {
            addCriterion("flag3 >", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3GreaterThanOrEqualTo(String value) {
            addCriterion("flag3 >=", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3LessThan(String value) {
            addCriterion("flag3 <", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3LessThanOrEqualTo(String value) {
            addCriterion("flag3 <=", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3Like(String value) {
            addCriterion("flag3 like", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3NotLike(String value) {
            addCriterion("flag3 not like", value, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3In(List<String> values) {
            addCriterion("flag3 in", values, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3NotIn(List<String> values) {
            addCriterion("flag3 not in", values, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3Between(String value1, String value2) {
            addCriterion("flag3 between", value1, value2, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag3NotBetween(String value1, String value2) {
            addCriterion("flag3 not between", value1, value2, "flag3");
            return (Criteria) this;
        }

        public Criteria andFlag4IsNull() {
            addCriterion("flag4 is null");
            return (Criteria) this;
        }

        public Criteria andFlag4IsNotNull() {
            addCriterion("flag4 is not null");
            return (Criteria) this;
        }

        public Criteria andFlag4EqualTo(String value) {
            addCriterion("flag4 =", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4NotEqualTo(String value) {
            addCriterion("flag4 <>", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4GreaterThan(String value) {
            addCriterion("flag4 >", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4GreaterThanOrEqualTo(String value) {
            addCriterion("flag4 >=", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4LessThan(String value) {
            addCriterion("flag4 <", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4LessThanOrEqualTo(String value) {
            addCriterion("flag4 <=", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4Like(String value) {
            addCriterion("flag4 like", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4NotLike(String value) {
            addCriterion("flag4 not like", value, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4In(List<String> values) {
            addCriterion("flag4 in", values, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4NotIn(List<String> values) {
            addCriterion("flag4 not in", values, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4Between(String value1, String value2) {
            addCriterion("flag4 between", value1, value2, "flag4");
            return (Criteria) this;
        }

        public Criteria andFlag4NotBetween(String value1, String value2) {
            addCriterion("flag4 not between", value1, value2, "flag4");
            return (Criteria) this;
        }

        public Criteria andFalg5IsNull() {
            addCriterion("falg5 is null");
            return (Criteria) this;
        }

        public Criteria andFalg5IsNotNull() {
            addCriterion("falg5 is not null");
            return (Criteria) this;
        }

        public Criteria andFalg5EqualTo(String value) {
            addCriterion("falg5 =", value, "falg5");
            return (Criteria) this;
        }

        public Criteria andFalg5NotEqualTo(String value) {
            addCriterion("falg5 <>", value, "falg5");
            return (Criteria) this;
        }

        public Criteria andFalg5GreaterThan(String value) {
            addCriterion("falg5 >", value, "falg5");
            return (Criteria) this;
        }

        public Criteria andFalg5GreaterThanOrEqualTo(String value) {
            addCriterion("falg5 >=", value, "falg5");
            return (Criteria) this;
        }

        public Criteria andFalg5LessThan(String value) {
            addCriterion("falg5 <", value, "falg5");
            return (Criteria) this;
        }

        public Criteria andFalg5LessThanOrEqualTo(String value) {
            addCriterion("falg5 <=", value, "falg5");
            return (Criteria) this;
        }

        public Criteria andFalg5Like(String value) {
            addCriterion("falg5 like", value, "falg5");
            return (Criteria) this;
        }

        public Criteria andFalg5NotLike(String value) {
            addCriterion("falg5 not like", value, "falg5");
            return (Criteria) this;
        }

        public Criteria andFalg5In(List<String> values) {
            addCriterion("falg5 in", values, "falg5");
            return (Criteria) this;
        }

        public Criteria andFalg5NotIn(List<String> values) {
            addCriterion("falg5 not in", values, "falg5");
            return (Criteria) this;
        }

        public Criteria andFalg5Between(String value1, String value2) {
            addCriterion("falg5 between", value1, value2, "falg5");
            return (Criteria) this;
        }

        public Criteria andFalg5NotBetween(String value1, String value2) {
            addCriterion("falg5 not between", value1, value2, "falg5");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}