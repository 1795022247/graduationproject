package com.jesper.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsTypeExample() {
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

        public Criteria andTypeNmaeIsNull() {
            addCriterion("type_nmae is null");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeIsNotNull() {
            addCriterion("type_nmae is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeEqualTo(String value) {
            addCriterion("type_nmae =", value, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeNotEqualTo(String value) {
            addCriterion("type_nmae <>", value, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeGreaterThan(String value) {
            addCriterion("type_nmae >", value, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeGreaterThanOrEqualTo(String value) {
            addCriterion("type_nmae >=", value, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeLessThan(String value) {
            addCriterion("type_nmae <", value, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeLessThanOrEqualTo(String value) {
            addCriterion("type_nmae <=", value, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeLike(String value) {
            addCriterion("type_nmae like", value, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeNotLike(String value) {
            addCriterion("type_nmae not like", value, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeIn(List<String> values) {
            addCriterion("type_nmae in", values, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeNotIn(List<String> values) {
            addCriterion("type_nmae not in", values, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeBetween(String value1, String value2) {
            addCriterion("type_nmae between", value1, value2, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andTypeNmaeNotBetween(String value1, String value2) {
            addCriterion("type_nmae not between", value1, value2, "typeNmae");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andFlag1IsNull() {
            addCriterion("flag1 is null");
            return (Criteria) this;
        }

        public Criteria andFlag1IsNotNull() {
            addCriterion("flag1 is not null");
            return (Criteria) this;
        }

        public Criteria andFlag1EqualTo(String value) {
            addCriterion("flag1 =", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1NotEqualTo(String value) {
            addCriterion("flag1 <>", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1GreaterThan(String value) {
            addCriterion("flag1 >", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1GreaterThanOrEqualTo(String value) {
            addCriterion("flag1 >=", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1LessThan(String value) {
            addCriterion("flag1 <", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1LessThanOrEqualTo(String value) {
            addCriterion("flag1 <=", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1Like(String value) {
            addCriterion("flag1 like", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1NotLike(String value) {
            addCriterion("flag1 not like", value, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1In(List<String> values) {
            addCriterion("flag1 in", values, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1NotIn(List<String> values) {
            addCriterion("flag1 not in", values, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1Between(String value1, String value2) {
            addCriterion("flag1 between", value1, value2, "flag1");
            return (Criteria) this;
        }

        public Criteria andFlag1NotBetween(String value1, String value2) {
            addCriterion("flag1 not between", value1, value2, "flag1");
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