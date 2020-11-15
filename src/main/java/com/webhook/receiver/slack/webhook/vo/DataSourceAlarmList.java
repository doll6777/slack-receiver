package com.webhook.receiver.slack.webhook.vo;

import java.util.ArrayList;

public class DataSourceAlarmList extends ArrayList<DataSourceAlarm> {
    @Override
    public String toString() {
        StringBuilder agentValues = new StringBuilder();
        for (DataSourceAlarm dataSourceAlarm : this) {
            agentValues.append(dataSourceAlarm.toString()).append("\n");
        }
        return agentValues.toString();
    }
}
