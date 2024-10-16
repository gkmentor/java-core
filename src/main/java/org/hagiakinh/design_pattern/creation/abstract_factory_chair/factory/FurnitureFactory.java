package org.hagiakinh.design_pattern.creation.abstract_factory_chair.factory;

import org.hagiakinh.design_pattern.creation.abstract_factory_chair.table.Table;
import org.hagiakinh.design_pattern.creation.abstract_factory_chair.chair.Chair;
public interface FurnitureFactory {
	Chair createChair();
	Table createTable();
}
