package org.example.springbootclassifier.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // Lombok will automatically generate getters, setters, toString, equals, and hashCode methods
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int battery_power;
    private int blue;
    private double clock_speed;
    private int dual_sim;
    private double fc;
    private double four_g;
    private double int_memory;
    private double m_dep;
    private double mobile_wt;
    private double n_cores;
    private double pc;
    private double ram;
    private int talk_time;
    private int three_g;
    private int touch_screen;
    private int wifi;
    private double sc_h;
    private double sc_w;
    private double px_height;
    private double px_width;
    @Column(nullable = true)
    private Integer predicted_price_range;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBattery_power() {
        return battery_power;
    }

    public void setBattery_power(int battery_power) {
        this.battery_power = battery_power;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public double getClock_speed() {
        return clock_speed;
    }

    public void setClock_speed(double clock_speed) {
        this.clock_speed = clock_speed;
    }

    public int getDual_sim() {
        return dual_sim;
    }

    public void setDual_sim(int dual_sim) {
        this.dual_sim = dual_sim;
    }

    public double getFc() {
        return fc;
    }

    public void setFc(double fc) {
        this.fc = fc;
    }

    public double getFour_g() {
        return four_g;
    }

    public void setFour_g(double four_g) {
        this.four_g = four_g;
    }

    public double getInt_memory() {
        return int_memory;
    }

    public void setInt_memory(double int_memory) {
        this.int_memory = int_memory;
    }

    public double getM_dep() {
        return m_dep;
    }

    public void setM_dep(double m_dep) {
        this.m_dep = m_dep;
    }

    public double getMobile_wt() {
        return mobile_wt;
    }

    public void setMobile_wt(double mobile_wt) {
        this.mobile_wt = mobile_wt;
    }

    public double getN_cores() {
        return n_cores;
    }

    public void setN_cores(double n_cores) {
        this.n_cores = n_cores;
    }

    public double getPc() {
        return pc;
    }

    public void setPc(double pc) {
        this.pc = pc;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public int getTalk_time() {
        return talk_time;
    }

    public void setTalk_time(int talk_time) {
        this.talk_time = talk_time;
    }

    public int getThree_g() {
        return three_g;
    }

    public void setThree_g(int three_g) {
        this.three_g = three_g;
    }

    public int getTouch_screen() {
        return touch_screen;
    }

    public void setTouch_screen(int touch_screen) {
        this.touch_screen = touch_screen;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public double getSc_h() {
        return sc_h;
    }

    public void setSc_h(double sc_h) {
        this.sc_h = sc_h;
    }

    public double getSc_w() {
        return sc_w;
    }

    public void setSc_w(double sc_w) {
        this.sc_w = sc_w;
    }

    public double getPx_height() {
        return px_height;
    }

    public void setPx_height(double px_height) {
        this.px_height = px_height;
    }

    public double getPx_width() {
        return px_width;
    }

    public void setPx_width(double px_width) {
        this.px_width = px_width;
    }

    public Integer getPredicted_price_range() {
        return predicted_price_range;
    }

    public void setPredicted_price_range(Integer predicted_price_range) {
        this.predicted_price_range = predicted_price_range;
    }
}