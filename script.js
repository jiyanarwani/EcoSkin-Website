// Function to show only the desired content section
function showSection(sectionId) {
    // Hide all sections
    document.getElementById('accountDetails').style.display = 'none';
    document.getElementById('yourSkin').style.display = 'none';
    document.getElementById('post').style.display = 'none';

    // Also hide the Create Post section if it exists
    const createPostSection = document.getElementById('createPostSection');
    if (createPostSection) {
        createPostSection.style.display = 'none';
    }

    // Show the selected section
    if (sectionId) {
        document.getElementById(sectionId).style.display = 'block';
    }
}

// Event listeners for sidebar buttons
document.getElementById('accountDetailsBtn').addEventListener('click', function() {
    showSection('accountDetails');
});

document.getElementById('yourSkinBtn').addEventListener('click', function() {
    showSection('yourSkin');
});

document.getElementById('postBtn').addEventListener('click', function() {
    showSection('post');
});

document.getElementById('createPostBtn').addEventListener('click', function() {
    // Create the post section if it doesn't already exist
    if (!document.getElementById('createPostSection')) {
        const createPostSection = document.createElement('div');
        createPostSection.id = 'createPostSection'; // Give it an ID to easily reference later
        createPostSection.innerHTML = `
            <h3>Create a New Post</h3>
            <label for="newPostText">Post Text:</label>
            <textarea id="newPostText" rows="4" cols="50"></textarea><br><br>
            <button id="addPostBtn" class="update-button">Add Post</button>
        `;
        document.querySelector('.content').appendChild(createPostSection);
    }

    // Show the Create Post section and hide all others
    showSection('createPostSection');
});

// Adding a post functionality
document.body.addEventListener('click', function(event) {
    if (event.target.id === 'addPostBtn') {
        const postText = document.getElementById('newPostText').value;
        if (postText.trim() !== "") {
            const postList = document.getElementById('postList');

            const newPostItem = document.createElement('div');
            newPostItem.className = 'post-item';

            newPostItem.innerHTML = `
                <p class="post-username">Ishita</p>
                <p class="post-text">${postText}</p>
                <p class="post-date">Posted on: ${new Date().toLocaleString()}</p>
            `;

            // Prepend the new post to the postList to show it on top
            postList.insertBefore(newPostItem, postList.firstChild);
            document.getElementById('newPostText').value = ''; // Clear the textarea
        } else {
            alert("Please write something before submitting!");
        }
    }
});

// Show the account details by default
showSection('accountDetails');
