$(function() {

	switch (menu) {

	case 'Abouts Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;

	default:
		$('#listProducts').addClass('active');
		$('#o_' + menu).addClass('active');
		break;

	}
});