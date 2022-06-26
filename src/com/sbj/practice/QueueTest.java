package com.sbj.practice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
	static Queue<Employee> pQueue = new PriorityQueue<QueueTest.Employee>();
	static Queue<Employee> linkedQueue = new LinkedList<QueueTest.Employee>();
	static private QueueTest queuTest = new QueueTest();
	
	public static void main(String[] args) {
		addEmployee(createEmployeeObj("A",12));
		addEmployee(createEmployeeObj("B",6));
		addEmployee(createEmployeeObj("C",15));
		addEmployee(createEmployeeObj("D",13));
		
		System.out.println("PQueue :");
		pQueue.stream().forEach(item ->System.out.println("Name:"+item.getName()+", Id:"+item.getId()));
		System.out.println("Linked Queue :");
		linkedQueue.stream().forEach(item ->System.out.println("Name:"+item.getName()+", Id:"+item.getId()));
	}
	private static Employee createEmployeeObj(String name, int id) {
		return queuTest.new Employee(name, id);
	}
	private static void addEmployee(Employee e) {
		pQueue.add(e);
		linkedQueue.add(e);
	}
	
	class Employee implements Comparable<Employee>{
		private String name;
		
		private Integer id;
		
		public Employee(String name, Integer id) {
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		@Override
		public int compareTo(Employee o) {
			return o.getId().compareTo(this.id);
		}
	}
}
