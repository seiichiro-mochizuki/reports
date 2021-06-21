package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "reports")
@NamedQueries({
    @NamedQuery(
        name = "getAllReports",
        query = "SELECT r FROM Report AS r ORDER BY r.id DESC"
    ),
    @NamedQuery(
        name = "getReportsCount",
        query = "SELECT COUNT(r) FROM Report AS r"
    ),
    @NamedQuery(
        name = "getMyAllReports",
        query = "SELECT r From Report AS r WHERE r.employee = :employee ORDER BY r.id DESC"
    ),
    @NamedQuery(
        name = "getMyReportsCount",
        query = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :employee"
    )
})
@Entity
public class Report {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "report_date", nullable = false)
    private Date report_date;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name = "commuting_hour", length = 2, nullable = false)
    private String commuting_hour;

    @Column(name = "commuting_minute", length = 2, nullable = false)
    private String commuting_minute;

    @Column(name = "leaving_hour", length = 2, nullable = false)
    private String leaving_hour;

    @Column(name = "leaving_minute", length = 2, nullable = false)
    private String leaving_minute;

    public String getCommuting_hour() {
        return commuting_hour;
    }

    public void setCommuting_hour(String commuting_hour) {
        this.commuting_hour = commuting_hour;
    }

    public String getCommuting_minute() {
        return commuting_minute;
    }

    public void setCommuting_minute(String commuting_minute) {
        this.commuting_minute = commuting_minute;
    }

    public String getLeaving_hour() {
        return leaving_hour;
    }

    public void setLeaving_hour(String leaving_hour) {
        this.leaving_hour = leaving_hour;
    }

    public String getLeaving_minute() {
        return leaving_minute;
    }

    public void setLeaving_minute(String leaving_minute) {
        this.leaving_minute = leaving_minute;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }





}

