/**
 * Created by korkota on 2/26/15.
 */

function itemsChanged() {
    var value = document.getElementsByTagName('select')[0].value;
    window.location.search = 'id=' + value;
}

function setLocale(locale) {
    setCookie("locale", locale, {expires: 3600});
    document.location.reload(true);
}

function setCookie(name, value, options) {
    options = options || {};

    var expires = options.expires;

    if (typeof expires == "number" && expires) {
        var d = new Date();
        d.setTime(d.getTime() + expires*1000);
        expires = options.expires = d;
    }
    if (expires && expires.toUTCString) {
        options.expires = expires.toUTCString();
    }

    value = encodeURIComponent(value);

    var updatedCookie = name + "=" + value;

    for(var propName in options) {
        updatedCookie += "; " + propName;
        var propValue = options[propName];
        if (propValue !== true) {
            updatedCookie += "=" + propValue;
        }
    }

    document.cookie = updatedCookie;
}

jQuery(document).ready(function($) {
    if (typeof CONFIG !== 'undefined') {
        $('#description a[href="#' + CONFIG.defaultTab + '"]').tab('show');
    }

    $('#description .nav.nav-tabs a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    });

});