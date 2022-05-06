

/* Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.*/
package pr2.pr2.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEPT database table.
 * Make sure to use the schema (JDBCSampleData.sql) at https://tinyurl.com/y2a7x65z 
 * @author Nirmala Sundarappa
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Dept.findAll", query="SELECT d FROM Dept d"),
	@NamedQuery(name="Dept.findEmpByDept", query="SELECT d.emps FROM Dept d where d.dname = :dname")	
})
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long deptno;

	private String dname;

	private String loc;

	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="dept")
	private List<Emp> emps;

	public Dept() {
	}

	public long getDeptno() {
		return this.deptno;
	}

	public void setDeptno(long deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp addEmp(Emp emp) {
		getEmps().add(emp);
		emp.setDept(this);

		return emp;
	}

	public Emp removeEmp(Emp emp) {
		getEmps().remove(emp);
		emp.setDept(null);

		return emp;
	}

}