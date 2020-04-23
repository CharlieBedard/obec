package cz.nigol.obec.beans;

import java.io.*;
import java.util.*;
import javax.inject.*;
import javax.faces.view.*;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.annotation.*;
import cz.nigol.obec.entities.*;
import cz.nigol.obec.services.*;

@Named
@ViewScoped
public class WaterSpendingBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private WaterSpendingService waterSpendingService;
    @Inject
    private FacesContext facesContext;
    private WaterSpending waterSpending;
    private boolean sent;

    @PostConstruct
    public void init() {
        waterSpending = new WaterSpending();
        waterSpending.setPeriod("4-2020");
        waterSpending.setCreatedAt(new Date());
        sent = false;
    }

    public void save() {
        waterSpendingService.saveWaterSpending(waterSpending);
        init();
        sent = true;
    }

    public boolean getSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public WaterSpending getWaterSpending() {
        return waterSpending;
    }

    public void setWaterSpending(WaterSpending waterSpending) {
        this.waterSpending = waterSpending;
    }
}