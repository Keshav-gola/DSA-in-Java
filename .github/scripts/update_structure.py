import os
from github import Github

def get_repo_structure(path='.', prefix=''):
    structure = []
    items = sorted(os.listdir(path))
    for i, item in enumerate(items):
        if item.startswith('.'):
            continue
        item_path = os.path.join(path, item)
        is_last = i == len(items) - 1
        current_prefix = '└── ' if is_last else '├── '
        structure.append(f"{prefix}{current_prefix}{item}")
        if os.path.isdir(item_path):
            next_prefix = prefix + ('    ' if is_last else '│   ')
            structure.extend(get_repo_structure(item_path, next_prefix))
    return structure

def update_structure_file(structure):
    with open('repo_structure.txt', 'w') as f:
        f.write('\n'.join(structure))

def main():
    g = Github(os.environ['GITHUB_TOKEN'])
    repo = g.get_repo(os.environ['GITHUB_REPOSITORY'])

    current_structure = get_repo_structure()

    try:
        contents = repo.get_contents("repo_structure.txt")
        existing_structure = contents.decoded_content.decode().split('\n')
    except:
        existing_structure = None

    if current_structure != existing_structure:
        update_structure_file(current_structure)
        print("Repository structure updated.")
    else:
        print("No changes in repository structure.")

if __name__ == "__main__":
    main()
