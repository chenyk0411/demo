package com.example.demo.beans.entity;

import java.util.Date;

public class ImmeEmp {
    private Short empno;

    private Short immeEmpId;

    private String empname;

    private String job;

    private Short mgr;

    private Date hiredate;

    private Short deptno;

    private String isValid;

    private Short auth;

    private String pwd;

    private String email;

    private String emp2;

    private String emp3;

    private String emp4;

    private String emp5;

    public ImmeEmp(Short empno, Short immeEmpId, String empname, String job, Short mgr, Date hiredate, Short deptno, String isValid, Short auth, String pwd, String email, String emp2, String emp3, String emp4, String emp5) {
        this.empno = empno;
        this.immeEmpId = immeEmpId;
        this.empname = empname;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.deptno = deptno;
        this.isValid = isValid;
        this.auth = auth;
        this.pwd = pwd;
        this.email = email;
        this.emp2 = emp2;
        this.emp3 = emp3;
        this.emp4 = emp4;
        this.emp5 = emp5;
    }

    public ImmeEmp() {
        super();
    }

    public Short getEmpno() {
        return empno;
    }

    public void setEmpno(Short empno) {
        this.empno = empno;
    }

    public Short getImmeEmpId() {
        return immeEmpId;
    }

    public void setImmeEmpId(Short immeEmpId) {
        this.immeEmpId = immeEmpId;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Short getMgr() {
        return mgr;
    }

    public void setMgr(Short mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Short getDeptno() {
        return deptno;
    }

    public void setDeptno(Short deptno) {
        this.deptno = deptno;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }

    public Short getAuth() {
        return auth;
    }

    public void setAuth(Short auth) {
        this.auth = auth;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEmp2() {
        return emp2;
    }

    public void setEmp2(String emp2) {
        this.emp2 = emp2 == null ? null : emp2.trim();
    }

    public String getEmp3() {
        return emp3;
    }

    public void setEmp3(String emp3) {
        this.emp3 = emp3 == null ? null : emp3.trim();
    }

    public String getEmp4() {
        return emp4;
    }

    public void setEmp4(String emp4) {
        this.emp4 = emp4 == null ? null : emp4.trim();
    }

    public String getEmp5() {
        return emp5;
    }

    public void setEmp5(String emp5) {
        this.emp5 = emp5 == null ? null : emp5.trim();
    }
}