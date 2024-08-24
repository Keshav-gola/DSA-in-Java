import os
import json
from github import Github

def get_repo_structure(path='.'):
    structure = {}
    for item in os.listdir(path):
        item_path = os.path.join(path, item)
        if os.path.isdir(item_path):
            structure[item] = get_repo_structure(item_path)
        else:
            structure[item] = None
    return structure

def update_structure_file(structure):
    with open('repo_structure.json', 'w') as f:
        json.dump(structure, f, indent=2)

def main():
    # Get the current repository
    g = Github(os.environ['GITHUB_TOKEN'])
    repo = g.get_repo(os.environ['GITHUB_REPOSITORY'])

    # Get the current structure
    current_structure = get_repo_structure()

    # Check if the structure file exists
    try:
        contents = repo.get_contents("repo_structure.json")
        existing_structure = json.loads(contents.decoded_content.decode())
    except:
        existing_structure = None

    # If the structure has changed or the file doesn't exist, update it
    if current_structure != existing_structure:
        update_structure_file(current_structure)
        print("Repository structure updated.")
    else:
        print("No changes in repository structure.")

if __name__ == "__main__":
    main()
