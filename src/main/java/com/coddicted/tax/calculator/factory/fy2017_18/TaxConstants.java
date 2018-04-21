package com.coddicted.tax.calculator.factory.fy2017_18;

import java.math.BigDecimal;

public class TaxConstants {

	public static final BigDecimal slab1 = new BigDecimal(2_50_000).setScale(2); // 5%
    public static final BigDecimal slab2 = new BigDecimal(5_00_000).setScale(2); // 20%	- common to all
    
    public static final BigDecimal SLAB1_BASE_SUPER_SENIORS = new BigDecimal(3_00_000);	// 0% for initial 3 Lac
    public static final BigDecimal SLAB1_SUPER_SENIORS = new BigDecimal(2_00_000);	// 5% for super senior
    //public static final BigDecimal slab3 = new BigDecimal(10_00_000).setScale(2);	// 30%

    public static final BigDecimal slab1Rate = new BigDecimal(0.05);	// 5%
    public static final BigDecimal slab2Rate = new BigDecimal(0.20);	// 20%
    public static final BigDecimal slab3Rate = new BigDecimal(0.30);	// 30%
    
    public static final BigDecimal surchargeRate = new BigDecimal(0.03);	// 3%

    // TODO need to check this amount
    public static final BigDecimal MAX_DEDUCTIBLE_AMOUNT = new BigDecimal(1_50_000);
}
