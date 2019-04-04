/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by Cloudream (cloudream@gmail.com). */
( function( factory ) {
    if ( typeof define === "function" && define.amd ) {

        // AMD. Register as an anonymous module.
        define( [ "../widgets/datepicker" ], factory );
    } else {

        // Browser globals
        factory( jQuery.datepicker );
    }
}( function( datepicker ) {

    datepicker.regional[ "zh-CN" ] = {
        closeText: "确定",
        prevText: "上月",
        nextText: "下月",
        currentText: "本月",
        monthNames: [ "01","02","03","04","05","06","07","08","09","10","11","12" ],
        monthNamesShort: [ "01","02","03","04","05","06","07","08","09","10","11","12" ],
        dayNames: [ "星期日","星期一","星期二","星期三","星期四","星期五","星期六" ],
        dayNamesShort: [ "周日","周一","周二","周三","周四","周五","周六" ],
        dayNamesMin: [ "日","一","二","三","四","五","六" ],
        weekHeader: "周",
        dateFormat: "yy-mm-dd",
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: true,
        yearSuffix: " " };
    datepicker.setDefaults( datepicker.regional[ "zh-CN" ] );

    return datepicker.regional[ "zh-CN" ];

} ) );