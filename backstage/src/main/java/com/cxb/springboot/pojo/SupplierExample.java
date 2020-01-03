package com.cxb.springboot.pojo;

import java.util.ArrayList;
import java.util.List;

public class SupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupplierExample() {
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

        public Criteria andGtidIsNull() {
            addCriterion("gtid is null");
            return (Criteria) this;
        }

        public Criteria andGtidIsNotNull() {
            addCriterion("gtid is not null");
            return (Criteria) this;
        }

        public Criteria andGtidEqualTo(Integer value) {
            addCriterion("gtid =", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidNotEqualTo(Integer value) {
            addCriterion("gtid <>", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidGreaterThan(Integer value) {
            addCriterion("gtid >", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gtid >=", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidLessThan(Integer value) {
            addCriterion("gtid <", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidLessThanOrEqualTo(Integer value) {
            addCriterion("gtid <=", value, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidIn(List<Integer> values) {
            addCriterion("gtid in", values, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidNotIn(List<Integer> values) {
            addCriterion("gtid not in", values, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidBetween(Integer value1, Integer value2) {
            addCriterion("gtid between", value1, value2, "gtid");
            return (Criteria) this;
        }

        public Criteria andGtidNotBetween(Integer value1, Integer value2) {
            addCriterion("gtid not between", value1, value2, "gtid");
            return (Criteria) this;
        }

        public Criteria andSlognameIsNull() {
            addCriterion("slogname is null");
            return (Criteria) this;
        }

        public Criteria andSlognameIsNotNull() {
            addCriterion("slogname is not null");
            return (Criteria) this;
        }

        public Criteria andSlognameEqualTo(String value) {
            addCriterion("slogname =", value, "slogname");
            return (Criteria) this;
        }

        public Criteria andSlognameNotEqualTo(String value) {
            addCriterion("slogname <>", value, "slogname");
            return (Criteria) this;
        }

        public Criteria andSlognameGreaterThan(String value) {
            addCriterion("slogname >", value, "slogname");
            return (Criteria) this;
        }

        public Criteria andSlognameGreaterThanOrEqualTo(String value) {
            addCriterion("slogname >=", value, "slogname");
            return (Criteria) this;
        }

        public Criteria andSlognameLessThan(String value) {
            addCriterion("slogname <", value, "slogname");
            return (Criteria) this;
        }

        public Criteria andSlognameLessThanOrEqualTo(String value) {
            addCriterion("slogname <=", value, "slogname");
            return (Criteria) this;
        }

        public Criteria andSlognameLike(String value) {
            addCriterion("slogname like", value, "slogname");
            return (Criteria) this;
        }

        public Criteria andSlognameNotLike(String value) {
            addCriterion("slogname not like", value, "slogname");
            return (Criteria) this;
        }

        public Criteria andSlognameIn(List<String> values) {
            addCriterion("slogname in", values, "slogname");
            return (Criteria) this;
        }

        public Criteria andSlognameNotIn(List<String> values) {
            addCriterion("slogname not in", values, "slogname");
            return (Criteria) this;
        }

        public Criteria andSlognameBetween(String value1, String value2) {
            addCriterion("slogname between", value1, value2, "slogname");
            return (Criteria) this;
        }

        public Criteria andSlognameNotBetween(String value1, String value2) {
            addCriterion("slogname not between", value1, value2, "slogname");
            return (Criteria) this;
        }

        public Criteria andSpasswordIsNull() {
            addCriterion("sPASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andSpasswordIsNotNull() {
            addCriterion("sPASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andSpasswordEqualTo(String value) {
            addCriterion("sPASSWORD =", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordNotEqualTo(String value) {
            addCriterion("sPASSWORD <>", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordGreaterThan(String value) {
            addCriterion("sPASSWORD >", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("sPASSWORD >=", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordLessThan(String value) {
            addCriterion("sPASSWORD <", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordLessThanOrEqualTo(String value) {
            addCriterion("sPASSWORD <=", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordLike(String value) {
            addCriterion("sPASSWORD like", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordNotLike(String value) {
            addCriterion("sPASSWORD not like", value, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordIn(List<String> values) {
            addCriterion("sPASSWORD in", values, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordNotIn(List<String> values) {
            addCriterion("sPASSWORD not in", values, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordBetween(String value1, String value2) {
            addCriterion("sPASSWORD between", value1, value2, "spassword");
            return (Criteria) this;
        }

        public Criteria andSpasswordNotBetween(String value1, String value2) {
            addCriterion("sPASSWORD not between", value1, value2, "spassword");
            return (Criteria) this;
        }

        public Criteria andSsaltIsNull() {
            addCriterion("ssalt is null");
            return (Criteria) this;
        }

        public Criteria andSsaltIsNotNull() {
            addCriterion("ssalt is not null");
            return (Criteria) this;
        }

        public Criteria andSsaltEqualTo(String value) {
            addCriterion("ssalt =", value, "ssalt");
            return (Criteria) this;
        }

        public Criteria andSsaltNotEqualTo(String value) {
            addCriterion("ssalt <>", value, "ssalt");
            return (Criteria) this;
        }

        public Criteria andSsaltGreaterThan(String value) {
            addCriterion("ssalt >", value, "ssalt");
            return (Criteria) this;
        }

        public Criteria andSsaltGreaterThanOrEqualTo(String value) {
            addCriterion("ssalt >=", value, "ssalt");
            return (Criteria) this;
        }

        public Criteria andSsaltLessThan(String value) {
            addCriterion("ssalt <", value, "ssalt");
            return (Criteria) this;
        }

        public Criteria andSsaltLessThanOrEqualTo(String value) {
            addCriterion("ssalt <=", value, "ssalt");
            return (Criteria) this;
        }

        public Criteria andSsaltLike(String value) {
            addCriterion("ssalt like", value, "ssalt");
            return (Criteria) this;
        }

        public Criteria andSsaltNotLike(String value) {
            addCriterion("ssalt not like", value, "ssalt");
            return (Criteria) this;
        }

        public Criteria andSsaltIn(List<String> values) {
            addCriterion("ssalt in", values, "ssalt");
            return (Criteria) this;
        }

        public Criteria andSsaltNotIn(List<String> values) {
            addCriterion("ssalt not in", values, "ssalt");
            return (Criteria) this;
        }

        public Criteria andSsaltBetween(String value1, String value2) {
            addCriterion("ssalt between", value1, value2, "ssalt");
            return (Criteria) this;
        }

        public Criteria andSsaltNotBetween(String value1, String value2) {
            addCriterion("ssalt not between", value1, value2, "ssalt");
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