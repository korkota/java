/**
 * Created by korkota on 2/26/15.
 */
jQuery(document).ready(function($) {
    $('#description a[href="#' + CONFIG.defaultTab + '"]').tab('show');

    $('#description .nav.nav-tabs a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    });
});