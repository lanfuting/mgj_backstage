package com.cxb.springboot.pojo;

import java.util.ArrayList;
import java.util.List;

public class SuppliergoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SuppliergoodsExample() {
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

        public Criteria andSsuppliergoodsidIsNull() {
            addCriterion("ssuppliergoodsid is null");
            return (Criteria) this;
        }

        public Criteria andSsuppliergoodsidIsNotNull() {
            addCriterion("ssuppliergoodsid is not null");
            return (Criteria) this;
        }

        public Criteria andSsuppliergoodsidEqualTo(Integer value) {
            addCriterion("ssuppliergoodsid =", value, "ssuppliergoodsid");
            return (Criteria) this;
        }

        public Criteria andSsuppliergoodsidNotEqualTo(Integer value) {
            addCriterion("ssuppliergoodsid <>", value, "ssuppliergoodsid");
            return (Criteria) this;
        }

        public Criteria andSsuppliergoodsidGreaterThan(Integer value) {
            addCriterion("ssuppliergoodsid >", value, "ssuppliergoodsid");
            return (Criteria) this;
        }

        public Criteria andSsuppliergoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ssuppliergoodsid >=", value, "ssuppliergoodsid");
            return (Criteria) this;
        }

        public Criteria andSsuppliergoodsidLessThan(Integer value) {
            addCriterion("ssuppliergoodsid <", value, "ssuppliergoodsid");
            return (Criteria) this;
        }

        public Criteria andSsuppliergoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("ssuppliergoodsid <=", value, "ssuppliergoodsid");
            return (Criteria) this;
        }

        public Criteria andSsuppliergoodsidIn(List<Integer> values) {
            addCriterion("ssuppliergoodsid in", values, "ssuppliergoodsid");
            return (Criteria) this;
        }

        public Criteria andSsuppliergoodsidNotIn(List<Integer> values) {
            addCriterion("ssuppliergoodsid not in", values, "ssuppliergoodsid");
            return (Criteria) this;
        }

        public Criteria andSsuppliergoodsidBetween(Integer value1, Integer value2) {
            addCriterion("ssuppliergoodsid between", value1, value2, "ssuppliergoodsid");
            return (Criteria) this;
        }

        public Criteria andSsuppliergoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("ssuppliergoodsid not between", value1, value2, "ssuppliergoodsid");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsIsNull() {
            addCriterion("ssup_goods is null");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsIsNotNull() {
            addCriterion("ssup_goods is not null");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsEqualTo(Integer value) {
            addCriterion("ssup_goods =", value, "ssupGoods");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsNotEqualTo(Integer value) {
            addCriterion("ssup_goods <>", value, "ssupGoods");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsGreaterThan(Integer value) {
            addCriterion("ssup_goods >", value, "ssupGoods");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ssup_goods >=", value, "ssupGoods");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsLessThan(Integer value) {
            addCriterion("ssup_goods <", value, "ssupGoods");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsLessThanOrEqualTo(Integer value) {
            addCriterion("ssup_goods <=", value, "ssupGoods");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsIn(List<Integer> values) {
            addCriterion("ssup_goods in", values, "ssupGoods");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsNotIn(List<Integer> values) {
            addCriterion("ssup_goods not in", values, "ssupGoods");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsBetween(Integer value1, Integer value2) {
            addCriterion("ssup_goods between", value1, value2, "ssupGoods");
            return (Criteria) this;
        }

        public Criteria andSsupGoodsNotBetween(Integer value1, Integer value2) {
            addCriterion("ssup_goods not between", value1, value2, "ssupGoods");
            return (Criteria) this;
        }

        public Criteria andSsupStatusIsNull() {
            addCriterion("ssup_status is null");
            return (Criteria) this;
        }

        public Criteria andSsupStatusIsNotNull() {
            addCriterion("ssup_status is not null");
            return (Criteria) this;
        }

        public Criteria andSsupStatusEqualTo(Integer value) {
            addCriterion("ssup_status =", value, "ssupStatus");
            return (Criteria) this;
        }

        public Criteria andSsupStatusNotEqualTo(Integer value) {
            addCriterion("ssup_status <>", value, "ssupStatus");
            return (Criteria) this;
        }

        public Criteria andSsupStatusGreaterThan(Integer value) {
            addCriterion("ssup_status >", value, "ssupStatus");
            return (Criteria) this;
        }

        public Criteria andSsupStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ssup_status >=", value, "ssupStatus");
            return (Criteria) this;
        }

        public Criteria andSsupStatusLessThan(Integer value) {
            addCriterion("ssup_status <", value, "ssupStatus");
            return (Criteria) this;
        }

        public Criteria andSsupStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ssup_status <=", value, "ssupStatus");
            return (Criteria) this;
        }

        public Criteria andSsupStatusIn(List<Integer> values) {
            addCriterion("ssup_status in", values, "ssupStatus");
            return (Criteria) this;
        }

        public Criteria andSsupStatusNotIn(List<Integer> values) {
            addCriterion("ssup_status not in", values, "ssupStatus");
            return (Criteria) this;
        }

        public Criteria andSsupStatusBetween(Integer value1, Integer value2) {
            addCriterion("ssup_status between", value1, value2, "ssupStatus");
            return (Criteria) this;
        }

        public Criteria andSsupStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ssup_status not between", value1, value2, "ssupStatus");
            return (Criteria) this;
        }

        public Criteria andGdidIsNull() {
            addCriterion("gdid is null");
            return (Criteria) this;
        }

        public Criteria andGdidIsNotNull() {
            addCriterion("gdid is not null");
            return (Criteria) this;
        }

        public Criteria andGdidEqualTo(Integer value) {
            addCriterion("gdid =", value, "gdid");
            return (Criteria) this;
        }

        public Criteria andGdidNotEqualTo(Integer value) {
            addCriterion("gdid <>", value, "gdid");
            return (Criteria) this;
        }

        public Criteria andGdidGreaterThan(Integer value) {
            addCriterion("gdid >", value, "gdid");
            return (Criteria) this;
        }

        public Criteria andGdidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gdid >=", value, "gdid");
            return (Criteria) this;
        }

        public Criteria andGdidLessThan(Integer value) {
            addCriterion("gdid <", value, "gdid");
            return (Criteria) this;
        }

        public Criteria andGdidLessThanOrEqualTo(Integer value) {
            addCriterion("gdid <=", value, "gdid");
            return (Criteria) this;
        }

        public Criteria andGdidIn(List<Integer> values) {
            addCriterion("gdid in", values, "gdid");
            return (Criteria) this;
        }

        public Criteria andGdidNotIn(List<Integer> values) {
            addCriterion("gdid not in", values, "gdid");
            return (Criteria) this;
        }

        public Criteria andGdidBetween(Integer value1, Integer value2) {
            addCriterion("gdid between", value1, value2, "gdid");
            return (Criteria) this;
        }

        public Criteria andGdidNotBetween(Integer value1, Integer value2) {
            addCriterion("gdid not between", value1, value2, "gdid");
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