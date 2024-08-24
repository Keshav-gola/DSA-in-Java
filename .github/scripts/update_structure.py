import os
from github import Github

def get_repo_structure(path='.', prefix=''):
    # ... (keep the existing get_repo_structure function as is)

def update_structure_file(structure):
    with open('repo_structure.txt', 'w') as f:
        f.write('\n'.join(structure))

def update_readme(structure):
    with open('README.md', 'r') as f:
        content = f.read()

    start_marker = '<!-- START_STRUCTURE -->'
    end_marker = '<!-- END_STRUCTURE -->'
    
    start_index = content.find(start_marker)
    end_index = content.find(end_marker)

    if start_index != -1 and end_index != -1:
        new_content = (
            content[:start_index + len(start_marker)] +
            '\n```\n' + '\n'.join(structure) + '\n```\n' +
            content[end_index:]
        )
        
        with open('README.md', 'w') as f:
            f.write(new_content)
        print("README.md updated with new structure.")
    else:
        print("Markers not found in README.md. Structure not updated.")

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
        update_readme(current_structure)
        print("Repository structure updated.")
    else:
        print("No changes in repository structure.")

if __name__ == "__main__":
    main()
