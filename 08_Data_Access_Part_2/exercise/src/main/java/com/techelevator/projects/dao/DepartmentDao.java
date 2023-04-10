package com.techelevator.projects.dao;

import com.techelevator.projects.model.Department;

import java.util.List;

public interface DepartmentDao {

	/**
	 * Get a department from the datastore that belongs to the given id.
	 * If the id is not found, return null.
	 *
	 * @param id the department id to get from the datastore
	 * @return a filled out department object
	 */
	Department getDepartmentById(int id);

	/**
	 * Get all departments from the datastore.
	 *
	 * @return all departments as Department objects in a List, if no results, returns an empty list
	 */
	List<Department> getDepartments();

	/**
	 * Inserts a new department into the datastore.
	 *
	 * @param department the department object to insert
	 * @return the department object with its new id filled in
	 */
	Department createDepartment(Department department);

	/**
	 * Updates an existing department in the datastore.
	 *
	 * @param department the department object to update
	 * @return the department object with its updated fields
	 */
	Department updateDepartment(Department department);

	/**
	 * Removes a department from the datastore, which requires deleting
	 * records from multiple tables.
	 *
	 * @param id the id of the department to remove
	 * @return the number of rows deleted
	 */
	int deleteDepartmentById(int id);
}
