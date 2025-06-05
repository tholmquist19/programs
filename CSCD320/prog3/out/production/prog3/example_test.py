import subprocess
def write_array_to_file(array, filename):
    """
    Writes each item of an array to a new line in a file named filename.
    Inputs:
        array: List of items to write to the file.
        filename: Name of the file to write to.
    Outputs:
        None
    """
    with open(filename, 'w') as file:
        for item in array:
            file.write(str(item) + '\n')
           
def compile_java_code_indir(java_file_name):
    """Compiles the Java code and returns True if successful, False otherwise."""
    try:
        subprocess.check_output(["javac", java_file_name], stderr=subprocess.STDOUT)
        return True
    except subprocess.CalledProcessError:
        return False
    
def run_command(command_list):
    timeout = 10
    try:
        # Run the command and wait for it to complete
        output = subprocess.check_output(command_list, timeout=timeout, stderr=subprocess.STDOUT)
        return output.decode('utf-8').strip()
    except subprocess.TimeoutExpired:
        # Return a message if the process times out
        print("TIMEOUT")
        return f"Function timed out after {timeout} seconds"
    except subprocess.CalledProcessError as e:
        # Return the error output if the command fails
        return e.output.decode('utf-8').strip()
    except Exception as e:
        # General exception handling
        return str(e)

if __name__=='__main__':
    compile_java_code_indir('FastMatrixMulti.java')
    test_1_file = 'matrices_1.txt'
    write_array_to_file([10,100,5,50], test_1_file)
    output = run_command(['java', 'FastMatrixMulti', test_1_file]).splitlines()
    if len(output) > 0 and output[0] == '((A1A2)A3)':
        print('Test 1 passed')
    else:
        print('Test 1 failed')
    if len(output) > 1 and output[1] == '7500':
        print('Test 2 passed')
    else:
        print('Test 2 failed')

