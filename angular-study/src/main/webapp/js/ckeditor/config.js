/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

//CKEDITOR.editorConfig = function( config )
//{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';

	//config.enterMode = CKEDITOR.ENTER_BR; 		// p | div | br
	//config.language		= 'zh-cn' ;
	//config.width = '1100px'; // 高度   
	//config.height = '300px'; // 高度   
//};
CKEDITOR.editorConfig = function( config )  
{  
config.language = 'zh-cn';  
    config.width = 1100;  
    config.height = 300;  
  //  config.skin = 'kama';  
    config.skin = 'v2'; 
// 背景颜色  
    //config.uiColor = '#BFEFFF';  
    config.uiColor = '##AADC6E';  
    
  config.toolbar_Full = [  
       ['Source','-','Save','NewPage','Preview','-','Templates'],  
       ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],  
       ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],  
       ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],  
       '/',  
       ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],  
        ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],  
        ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],  
        ['Link','Unlink','Anchor'],  
       ['Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],  
       ['Link','Unlink','Anchor'],  
       '/',  
        ['Styles','Format','Font','FontSize'],  
        ['TextColor','BGColor']  
    ];  
    }; 
