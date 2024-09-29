package org.hagiakinh.core.constant;

public enum Season {
    SPRING("SPRING", 1, 3);

	private String name;
    private Integer startMonth;
    private Integer endMonth;

    Season(String name, int startMonth, int endMonth) {
        this.name = name;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
    }

    public String getName() {
        return name;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public Integer getEndMonth() {
        return endMonth;
    }
}
