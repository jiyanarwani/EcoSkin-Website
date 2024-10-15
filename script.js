document.getElementById('accountDetailsBtn').addEventListener('click', function() {
    document.getElementById('accountDetails').style.display = 'block';
    document.getElementById('yourSkin').style.display = 'none';
    document.getElementById('post').style.display = 'none';
});

document.getElementById('yourSkinBtn').addEventListener('click', function() {
    document.getElementById('accountDetails').style.display = 'none';
    document.getElementById('yourSkin').style.display = 'block';
    document.getElementById('post').style.display = 'none';
});

document.getElementById('postBtn').addEventListener('click', function() {
    document.getElementById('accountDetails').style.display = 'none';
    document.getElementById('yourSkin').style.display = 'none';
    document.getElementById('post').style.display = 'block';
});
