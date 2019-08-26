package edu.trv.view.roottab.statisticstab;

import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.config.builder.*;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.github.appreciated.apexcharts.config.datalables.builder.DropShadowBuilder;
import com.github.appreciated.apexcharts.config.datalables.builder.StyleBuilder;
import com.github.appreciated.apexcharts.config.legend.Position;
import com.github.appreciated.apexcharts.config.responsive.builder.OptionsBuilder;
import com.vaadin.flow.component.html.Div;
import edu.trv.spring.resources.Text;
import edu.trv.spring.services.StatisticsService;

import java.util.List;

class SummayChart extends Div {

    // -----------------------------------------------------------------------------------------------------------------

    private final StatisticsService statisticsService;

    // -----------------------------------------------------------------------------------------------------------------

    SummayChart(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
        initChart();
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void initChart() {
        ApexCharts donutChart = new ApexCharts()
                .withChart(ChartBuilder.get()
                        .withType(Type.donut)
                        .withHeight("400")
                        .withWidth("400")
                        .build())
                .withLegend(LegendBuilder.get()
                        .withPosition(Position.right)
                        .build())
                .withSeries(
                          (double) statisticsService.getStatistics().getNumPassTests()
                        , (double) statisticsService.getStatistics().getNumFailedTests())
                .withColors("#00FF7F", "#FA8072")
                .withLabels(Text.PIE_CHART_LEGEND_PASS.toString(), Text.PIE_CHART_LEGEND_FAIL.toString())
                .withTooltip(TooltipBuilder.get()
                        .withFillSeriesColor(false)
                        .build())
                .withDataLabels(DataLabelsBuilder.get()
                        .withStyle(StyleBuilder.get()
                                .withColors(List.of("#000000"))
                                .build())
                        .withDropShadow(DropShadowBuilder.get()
                                .withEnable(false)
                                .build())
                        .build())
                .withResponsive(ResponsiveBuilder.get()
                        .withOptions(OptionsBuilder.get()
                                .withLegend(LegendBuilder.get()
                                        .withPosition(Position.bottom)
                                        .build())
                                .build())
                        .build());
        add(donutChart);
        setWidth("100%");
    }

    // -----------------------------------------------------------------------------------------------------------------
}

